@Library ("my_shared_library") _ 
pipeline {
    agent {
        // label "node-sportsdata"
        label "node-1"
    }
    environment {
        giturl = "https://SciflareIT@bitbucket.org/fantasysportpro/fantasypro_sportsdata.git"
        gitbranch = "master"
    }
    stages{
        stage("Checkout Scm"){
            steps{
                script{
                    echo "******************* Sportsdata *******************"
                    echo "Giturl : ${giturl}"
                    echo "GitBranch : ${gitbranch}"
                    dir("sportsdata-microservices"){
                        checkoutCode.gitcheckout(giturl,gitbranch)
                    }
                }
            }
        }
        stage("Checkout Devops Repo"){
            steps{
                script{
                    echo "Checkout devops dir"
                    checkoutCode.devopscheckout()
                }
            }
        }
        stage("Stoping Old Dockercontainers"){
            steps{
                script{
                    echo "*** Docker compose containers ***" 
                    def containerRuning = sh(script:"docker ps -q ",returnStdout: true).trim()
                    if (containerRuning) {
                        echo "Container Found .Stopping Container"
                        sh "docker compose down"
                    } else {
                        echo "No running Container found .Skipping Stages >> "
                    }
                }
            }
        }
        stage("Remove Old DockerImages And Containers"){
            steps{
                script{
                    echo "*** Delete Old Images ***"
                    sh "docker system prune -a -f"
                }
            }
        }
        stage("Docker Compose Up"){
            steps{
                script{
                    echo "*** Running Docker compose Up ***"
                    sh "docker compose up -d api cron"
                    sh "docker images && docker ps"
                }
            }
        }
    }
}