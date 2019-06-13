# Semantic-Observer
This module is responsible for observing changes that are made in the model.

# Introduction
The semantic observer module is responsible for observing the changes made in a semantic model. To do this, the soft-iot-semantic-observer module uses SPARQL queries.


# Installation

Before installing the Semantic-Observer module you need to introduce some Vert.x modules to ServiceMix. The dependencies are located at:

fot-gateway-semantic-enrichmen/jena-gateway.kar/target/jena-gateway.kar-1.0-SNAPSHOT.kar
to:

<servicemix_directory>/deploy


# Deployment
For installation of soft-iot-vertx-mqtt-broker it is necessary to execute the following commands in the ServiceMix terminal:

```
karaf@root()> bundle:install mvn:br.ufba.dcc.wiser.soft_iot/soft-iot-vertx-mqtt-broker/1.0.0
```
## Support and development

<p align="center">
	Developed by Cleber Lira at </br>
  <img src="https://wiki.dcc.ufba.br/pub/SmartUFBA/ProjectLogo/wiserufbalogo.jpg"/>
</p>

