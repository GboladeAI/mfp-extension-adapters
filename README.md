# mfp-extension-adapters

1) MFP Extension Adapters for Watson Congnitive Services such as Watson Conversation,Watson Tone Analyzer, Watson Language Understanding, Watson Natural Language Understanding and Watson Discovery. Using these MobleFirst Platform Adapters customer can quickly build a cognitive mobile apps and leverage IBM MobileFirst Platform capabilities

2) MFP Extension Adapter for OpenWhisk - Customer can quickly build a serverless mobile application using OpenWhisk Adapter

# Pre-built Adapters

The pre-built adapters for each of the Watson Cognitive Service and OpenWhisk can be found in the respective directory. 
These adapters can be downloaded and deployed to MFP Server to be used in the mobile app.

# Building the Adapters

Clone the repository and go to the respective directory and run the command :

mvn clean install

This command will build the adapter and it will be available under the "target" folder. This adapter
can be deployed on to a MFP Server and used in the mobile applications.
