def gv
pipeline{
    agent any

    environment {
		DOCKERHUB_CREDENTIALS=credentials('hub-docker-repo')
	}

    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("test-Environment"){
            steps{
                script {
                    gv.testEnv ()
                }
            }   
        }
        stage("build-Image"){
            steps{
                script { 
                 gv.buildImage()
                } 
            }   
        }
    }
}