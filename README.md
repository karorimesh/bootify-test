# bootify-test

## Steps to build and run the application locally using Docker.

Clone the repo(main branch)
Execute the command docker build -t your-preffered-name .
Execute the command docker run -p 8080:8080 your-preffered-name
Example for a db running locally
docker run -p 8080:8080 -e JDBC_DATABASE_URL="jdbc:postgresql://host.docker.internal:5432/bootify-test" karorimesh/bootify-test:latest
you can provide more environment varibles for JDBC_DATABASE_USERNAME and JDBC_DATABASE_PASSWORD
Open localhost:8080/swagger-ui/index.html# to view the API documentation
## Steps to deploy the application on Minikube, including:
## Required Minikube setup commands.
From the minikube official site follow instructions to setup minikube

Clone the project and cd into project directory
Edit the mini-deploy.yaml file and make necessary environment variable changes
Ensure minikube is your cuurent context for kubectl using the below command 
kubectl config current-context
Run the below command to apply the manifest file and run the app
kubectl apply -f .\mini-deploy.yaml
## How to access the application.
To view the running app run the below command that opens the app on a default browser
minikube service bootify-test-service OR
minikube service bootify-test-service --url to get the project link
Append to the link opened swagger-ui/index.html# to view the API documentation
## Explanation of the CI/CD pipeline in GitHub Actions.
The CICD are Github actions set on the repo
Defined in the .github/workflows fold
If a push or a pull request is made to main branch the workflow is triggered
the workflow then builds the app
creates a docker image 
and pushes it to docker hub to my account which is set up using secrets.
## Any decisions, assumptions, or challenges faced.
Assumption is that the db is separate from this app deployment
The application runs on a windows, above instructions are on a windows but can work in linux distros
A challenge on permissions in the CICD server for workflows- but was resolved