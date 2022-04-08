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
        stage("test-Environment"){
            steps{
                echo"hallo"
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