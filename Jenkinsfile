@Library('my_shared_library')_

def workspace;
def branch;
def appDeployProcess;
def dockerImage;
def configserveruri='';
def props='';
def microserviceName;
def port;
def gitUrl;
def repoName;
def Cusername;
def Cemail;

node {
    stage('Checkout Code')
    {
	checkout scm
	workspace = pwd() 
	 props = readProperties  file: """deploy.properties"""
	     sh "ls -lat"
	   
    }
    
    stage ('Static Code Analysis')
    { 
	    sonarexec
    }
    
     stage ('Build and Unit Test Execution')
    {
    }
    
     stage ('Code Coverage')
    { 
    }
    
     stage ('Create Docker Image')
    { 
	     echo 'creating an image'
	    dockerImage = dockerexec "${props['deploy.microservice']}"
    }
    
     stage ('Push Image to Docker Registry')
    { 
	    /* withCredtial'https://registry.hub.docker.com','docker-cred') {
             dockerImage.push("${BUILD_NUMBER}")
             dockerImage.push("latest")
	     }*/
	    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-cred',
        usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
      sh 'docker login -u "$USERNAME" -p "$PASSWORD"'
      dockerImage.push("${BUILD_NUMBER}")
             dockerImage.push("latest")
    }
    }
    
    stage ('Deploy to Kubernetes')
    { 
	    helmcreate ["${props['deploy.microservice']}","${props['deploy.port']}", "${dockerImage}"]
    }
	
}
		
