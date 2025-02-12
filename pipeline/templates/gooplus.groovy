@Library ("my_shared_library") _ 
pipeline{
    // Node - 1 
    agent {
        label "node-1"
    }

    environment {
        GIT_URL = "https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git"
        GIT_BRANCH = "seran_dev"
        API_IMAGE_NAME = 'apigoo'
        CRON_IMAGE_NAME = 'crongoo'
        IMAGE_TAG = 'latest'
        API_DOCKERPATH = "api/Dockerfile"
        CRON_DOCKERPATH = "cron/Dockerfile"
        REPO_NAME_API = "829173323501.dkr.ecr.ap-south-1.amazonaws.com/apigoo:latest"
        REPO_NAME_CRON = "829173323501.dkr.ecr.ap-south-1.amazonaws.com/crongoo:latest"
        PLAYBOOK = "goodeploy.yml"
        ANSIBLE_DIR = "/GooplusBuildDeploy/playbook"
    }
    stages{
        stage("Checkout-Code"){
            steps{
                script{
                    checkoutCode.gitcheckout(GIT_URL,GIT_BRANCH)
                }
            }
        }
        stage("Build Docker Image"){
            steps{
                script{
                    dockerbuild.buildimage(API_IMAGE_NAME,IMAGE_TAG,API_DOCKERPATH)
                    dockerbuild.buildimage(CRON_IMAGE_NAME,IMAGE_TAG,CRON_DOCKERPATH)
                }
            }
        }
        stage("Push Docker Image into Aws Ecr Repo"){
            steps{
                script{
                    dockerpush.dockerpush(API_IMAGE_NAME,IMAGE_TAG,REPO_NAME_API)
                    dockerpush.dockerpush(CRON_IMAGE_NAME,IMAGE_TAG,REPO_NAME_CRON)
                }
            }
        }
        stage("Ansible CheckOut"){
            // agent{label "AnsibleDeployment"}
            steps{
                script{
                    checkoutCode.ansiblecheckout()
                }
            }
        }
        stage("Deployment in Application server"){
            // agent{label "AnsibleDeployment"}
            steps{
                script{
                    deploy.deploydocker(PLAYBOOK,ANSIBLE_DIR)
                }
            }
        }            
    }
    post{
        always{
            node("node-1"){
                script{
                    cleanup.cleanup()
                }
            }
        }
    }
}

