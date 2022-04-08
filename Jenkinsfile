def gv
pipeline{
    agent any
    stages{
        stage("init")
            steps{
                script {
                    gv = load "script.groopy"
                }
            }
        stage("Test environment"){
            steps{
                script {
                    gv.testEnv()
                }
            }   
        }
    }
    stages{
        stage("build Docker"){
            steps{
                script {
                    gv.buildImage ()
                }
               
            }   
        }
    }
     stages{
        stage("push to hub.docker"){
            steps{
               echo " push to repository rundcode/sosmed-jenkins:latest"
               gv.pushImage ()
            }   
        }
    }
}
