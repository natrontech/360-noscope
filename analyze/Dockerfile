#################
# Backend build #
#################
FROM maven:3.9-eclipse-temurin-17 as build

WORKDIR /app
COPY ./pom.xml ./pom.xml
COPY ./src ./src

RUN mvn dependency:go-offline -B
RUN mvn package

####################
# Production build #
####################
FROM alpine:3.18

# alpine base instructions
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en' LC_ALL='en_US.UTF-8'
RUN apk add --no-cache --virtual .timezone tzdata && \
      cp /usr/share/zoneinfo/Europe/Zurich /etc/localtime && \
      echo "Europe/Zurich" >  /etc/timezone && \
      apk del .timezone
RUN apk add --no-cache tini curl jq
RUN adduser -h /app -s /bin/sh -u 1001 app -D

ENV JAVA_HOME=/opt/jdk \
    PATH=${PATH}:/opt/jdk/bin

# for upgrades: please copy&paste the following part from the corresponding Dockerfile from https://github.com/adoptium/containers
# source: https://github.com/adoptium/containers/blob/main/17/jdk/alpine/Dockerfile.releases.full
RUN apk add --no-cache fontconfig libretls musl-locales musl-locales-lang ttf-dejavu tzdata zlib \
    && rm -rf /var/cache/apk/*

# install openjdk17
RUN echo "get actual OpenJDK17 link and download" \
  && cd /tmp \
  && curl --silent -L "https://api.adoptium.net/v3/assets/feature_releases/17/ga?architecture=x64&heap_size=normal&image_type=jdk&jvm_impl=hotspot&os=alpine-linux&page=0&page_size=1&project=jdk&sort_method=DEFAULT&sort_order=DESC&vendor=eclipse" > info.json \
  && LINK=$(jq -r '.[0].binaries[0].package.link' info.json) \
  && FILENAME=$(jq -r '.[0].binaries[0].package.name' info.json) \
  && CHECKSUM_LINK=$(jq -r '.[0].binaries[0].package.checksum_link' info.json) \
  && CHECKSUM_FILENAME=$FILENAME.sha256.txt \
  && rm info.json \
  && curl --silent -L -o /tmp/$FILENAME $LINK \
  && curl --silent -L -o /tmp/$CHECKSUM_FILENAME $CHECKSUM_LINK \
  && echo "Verify checksum" \
  && sha256sum -c /tmp/$CHECKSUM_FILENAME \
  && echo "Checksum is correct" \
  && rm /tmp/$CHECKSUM_FILENAME \
  && EXTRACT_FOLDER=$(tar -tzf /tmp/$FILENAME | head -1 | awk -F/ '{ print $1 }') \
  && echo "extract OpenJDK to /opt/$EXTRACT_FOLDER" \
  && mkdir -p /opt \
  && tar xzf /tmp/$FILENAME -C /opt/ \
  && chown -R root:root /opt/$EXTRACT_FOLDER \
  && echo "export JAVA_HOME=/opt/$EXTRACT_FOLDER" >> /etc/profile.d/jdk.sh \
  && echo "export PATH=\$PATH:/opt/$EXTRACT_FOLDER/bin" >> /etc/profile.d/jdk.sh \
  && ln -s /opt/$EXTRACT_FOLDER /opt/jdk \
  && /opt/jdk/bin/java -version

USER app
COPY --from=build --chown=app /app/target/analyze-*.jar /app/analyze.jar
EXPOSE 8000
ENTRYPOINT [ "tini", "--" ]
CMD ["java", "-jar", "/app/analyze.jar"]
