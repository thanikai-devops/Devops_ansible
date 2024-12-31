
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