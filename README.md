cf-profile-demo
===============

Demonstrates how you can use Spring Profiles in a cloud foundry app by messin' with environment variables.

Assuming you have a Pivotal Cloud Foundry account, or access to a Cloud Foundry instance, and that you have two spaces, one called 'development' and one called 'qa':

To deploy to development space.
Change directories to wherever you have locally placed this project.
log into CF
Set your target:  cf target api.run.pivotal.io
Set space to development:  cf space development
Push the app using a specific namespace:  cf push --manifest dev-manifest.yml
Use a browser to access it.  Should be http://cf-profile-test-dev.cfapps.io


To deploy to QA space:
Follow the same instructions, but replace "development" with "qa"
