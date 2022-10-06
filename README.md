# XNAT FHIR Plugin

XNAT FHIR Plugin provides a Schema and a REST implementing the HL7 FHIR protocol.


This project is being unarchied with the aim of bringing it up to date for use on XNAT `1.8+` 

- The original is over 4 years old and the build system uses an antiquated version of gradle (`4.8`).
- The official [xnat-template-plugin](https://bitbucket.org/xnatx/xnat-template-plugin) as of 2021-09-28 uses `7.2`
- There are also many implementation differences in the build system scripting and configuration

The first step was to replace the now defuct "artifactoryonline.com" maven repository with mirror provided by [jfrog](jrog.io) in the gradle build system

It is now possible to build a jar using gradle `4.8`, I find the most multiplatform approach to achieve this is to use the offical gradle docker images

for example:

```shell
git clone git@github.com:somnonetz/xnat-fhir-plugin.git && cd xnat-fhir-plugin
docker run --rm -it -v $(pwd):/home/gradle  gradle:4.8.1-jdk8 gradle jar
sudo chown -R $USER:$USER build
```

## Installation

Please follow the instructions in the official [XNAT documentation](https://wiki.xnat.org/display/XNAT18/Deploying+Plugins+in+XNAT).

## Authors

Maryna Khvastova, Michael Witt, Sabina Mollenhauer, Tabea Herrmann, Isabella Kaupp Rivadeneira, James Bowden

## Acknowledgements

XNAT FHIR Plugin is developed at [CBMI](https://cbmi.htw-berlin.de/) (HTW Berlin - University of Applied Sciences).
