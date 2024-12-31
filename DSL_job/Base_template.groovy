
pipelineJob("GooplusBuildDeploy"){
    description("This GooplusBuildDeploy Job Indicates build the job and Deploy into the Aws Servers ")

    definition{
        cpsScm{
            scm{
                git ("url"){
                    branch ('feature-jenkins')
                }


            }
            scriptPath('pipeline/templates/jenkinsfile')
        }
    }
}