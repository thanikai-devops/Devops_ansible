@Library ("my_shared_library") _ 
pipeline {
    agent {
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
                    echo "GitBranch" : ${gitbranch}
                    checkoutCode.gitcheckout(giturl,gitbranch)
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
        stage("Build DockerCompose"){
            steps{
                script{
                    echo "Docker compose Logic **************"
                }
            }
        }
    }
}