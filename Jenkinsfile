def gv
pipeline{
    agent any
    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groopy"
                }
            }
        }
        stage("testEnvironment"){
            steps{
                script {
                    gv.testEnv()
                }
            }   
        }
        stage("buildImage"){
            steps{
                script {
                    gv.buildImage()
                }
               
            }   
        }
        stage("pushImage"){
            steps{
                script {
                    gv.pushImage ()
                }
            }   
        }
    }
}
