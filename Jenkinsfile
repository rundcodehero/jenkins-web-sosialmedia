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
                sh 'docker --version'
                sh 'php --version'
                }
            }   
        }
        stage("build-Image"){
            steps{
                script { 
                withCredentials [usernamePassword(credentialsID: 'hub-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]
                    sh "echo 'building sosmed image..'"
                    sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
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
