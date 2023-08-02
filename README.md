<h1>as-team1-api project</h1>

<h2>PROBLEM STATEMENT</h2>
<p>Currently, within Kainos there is not one source of truth
to view job roles and the relevant information attached
(e.g. job descriptions, capability, competencies, banding etc)
this can be confusing and time-consuming for employees to retrieve
the relevant job role information.</p>

<h2>VISION</h2>
<p>An online job application that serves both Kainos employees and
recruitment admin to retrieve and update job roles and their relevant information.
This repository covers all backend code required within a two-week sprint. </p>

<h2>Running application</h2>
On downloading the repo, running the trueApplication main class will start the application.

<h2>Deployment</h2>
The service is deployed to production via github actions.
These actions takes the code from this repo, logs into amazon ECS and using Docker, builds then pushes a docker container to the ECS instance.

<h2>Seeing the live service in production</h2>
You can visit the URL below to see our endpoints running on an amazon ECS instance:
https://ebbxsctpj8.eu-west-1.awsapprunner.com/swagger#/Commit%20Connoisseurs%20API/getAllJobRoles

<h2>Testing</h2>
Tests can be ran locally by running the series of
J-unit and integration tests within the 'test folder'.
Mocking tests are performed by Mockito.

<h2>Linting</h2>
Linting is applied by Maven Spotless on commit thanks to JHusky.
Git hooks run the mvn spotless:check and mvn spotless:apply each time a commit takes place.
The Maven Github action for this repo also applies linting and conducts a check.
