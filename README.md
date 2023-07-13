# XNAT FHIR Plugin

XNAT FHIR Plugin provides a Schema and a REST implementing the HL7 FHIR protocol.


This project is being unarchived with the aim of bringing it up to date for use on XNAT `1.8+` 

## Build

```shell
git clone git@github.com:somnonetz/xnat-fhir-plugin.git && cd xnat-fhir-plugin
./gradlew clean xnatPluginJar
```

## Installation

Please follow the instructions in the official [XNAT documentation](https://wiki.xnat.org/display/XNAT18/Deploying+Plugins+in+XNAT).

## Data Import

### FHIR Profile Patient
Since in XNAT one subject means one patient, we should only create one FHIR Patient per subject to keep the reliability of our data.
To import data by .csv file we need to take care of data type validation and error messages if failed. 

## Authors

Maryna Khvastova, Michael Witt, Sabina Mollenhauer, Tabea Herrmann, Isabella Kaupp Rivadeneira, James Bowden, Yufei Zhu

## Acknowledgements

XNAT FHIR Plugin is developed at [CBMI](https://cbmi.htw-berlin.de/) (HTW Berlin - University of Applied Sciences) and [MI](https://medizininformatik.umg.eu/) (UMG, Universitätsmedizin Göttingen).
