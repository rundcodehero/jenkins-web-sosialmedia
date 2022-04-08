def gv
pipeline {
    agent any
    stages{
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy" 
                }
            }
        }
        stage("Test environment"){
            steps{
               script {
                   gv.testEnv()
               }
            }   
        }  
        stage("build Docker"){
        label "node"
            steps{
                script {
                  gv.buildImage()
                }
               
            }   
        }
        stage("push to hub.docker"){
            steps{
               echo " push to repository rundcode/sosmed-jenkins:1.0"
               gv.pushImage()
            }   
        }
    }
}