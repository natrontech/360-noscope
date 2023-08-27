<p align="center">
    <a href="https://github.com/natrontech/360-noscope">
        <img height="120px" src="./assets/360-noscope.png" />
    </a>
    <h1 align="center">
        360° noscope
    </h1>
</p>

<p align="center">
  <a href="https://github.com/natrontech/360-noscope/issues"><img
    src="https://img.shields.io/github/issues/natrontech/360-noscope"
    alt="Build"
  /></a>
  <a href="https://github.com//natrontech/360-noscope"><img
    src="https://img.shields.io/github/license/natrontech/360-noscope"
    alt="License"
  /></a>
</p>

<p align="center">
  Digital evolution of the 360° scan analysis tool of <a href="https://planval.ch/">Planval AG</a>! :rocket:
</p>

<br>

## Overview

In order to support swiss municipalities in shaping a livable future and promoting sustainable development, [Planval AG](https://planval.ch/) has developed the 360° scan analysis tool, which measures the attractiveness of a location on the basis of several indicators from the areas of economy, society and environment :seedling:

**360° noscope** is the digital evolution of this tool, which focuses on the automation of data processing.

### Components

For more details, have a look at the [architecture](./docs/architecture.md)

- [Analyzer](./analyze): Perform analytics on data & provide a REST-API for the web frontend
- [Data Crawlers](./crawler): Python scripts to grab data from other APIs on the internet and push it to the ELK stack
- [UI](./ui): Web frontend with [Pocketbase](https://pocketbase.io/) as backend
- [Infra](./infra/fluxcd/): Resources for Deployment on Kubernetes with [fluxcd](https://fluxcd.io/)

### Getting started and documentation

To get started check out this [guide](./docs/getting-started.md) on how to build/run the application.  
For more information, go to the [docs](./docs).

### Open Source

Trust me, I'm open source.  
You can find the source code on [Github](https://github.com/natrontech/360-noscope).  
License: GPL 3
