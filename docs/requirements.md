# Requirements

To find your way around the environment, you need certain know-how but also requirements for the client device so that you can connect at all.

## :books: Know-How

| topic | requirement |
| -- | -- |
| **Git** | Knows the most important Git commands |
| | GPG `signed commits` are **enforced** |
| **GitHub** | Knows the most important GitHub functions: |
| | - `GitHub Issues` |
| | - `GitHub Pull Requests` |
| | - `GitHub Workflows` |
| | - `GitHub Releases` |
| | - `GitHub Repositories` |
| **Docker** | The application is dockerized and stateless |
| | Knows the most important `docker` commands |
| **Kubernetes** | Knows the concept of Kubernetes |
| | Knows the most important `kubectl` commands |

## Setup pre-commit

We use pre-commit to make several checks to identifying some issues on every commit.

1. [install the pre-commit binary](https://pre-commit.com/#install)

2. Setup pre-commit for this repository:

```bash
# go to the root of the cloned git repository

$ pre-commit install
pre-commit installed at .git/hooks/pre-commit
```

## Technical requirements

The following programs must be installed on your system:

- Java 17
- Maven
- Node version >= 16
- Docker