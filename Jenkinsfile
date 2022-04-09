def gv
pipeline{
    agent any

    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("test-Env"){
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
         stage("pushImage"){
            steps{
                script { 
                 gv.pushImage()
                } 
            }   
        }
        stage("runImage2"){
            steps{
                script { 
                 gv.runImage()
                } 
            }   
        }
    }
}