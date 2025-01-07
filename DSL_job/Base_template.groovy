// Here we can mention Checkout Repo with git url if jenkinsfile in application code Repo or if your jenkinsfile in another repo and application code in another Repo 
// you can handle both URL in Various Method
pipelineJob("GooplusBuildDeploy"){
    description("This GooplusBuildDeploy Job Indicates build the job and Deploy into the Aws Servers ")

    definition{
        cpsScm{
            scm{
                git ("https://github.com/thanikai-devops/Devops_ansible.git"){
                    branch ('feature-jenkins')
                }


            }
            scriptPath('pipeline/templates/jenkinsfile')
        }
    }
}
