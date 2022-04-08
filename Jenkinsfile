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
        stage("test-Environment"){
            steps{
                script {
                    gv.testEnv()
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
        stage("push-Image"){
            steps{
                script {
                    gv.pushImage ()
                }
            }   
        }
    }
}
