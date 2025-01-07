
pipelineJob("GooplusBuildDeploy"){
    description("This GooplusBuildDeploy Job Indicates build the job and Deploy into the Aws Servers ")

    parameters{
        stringParam('GIT_URL' , "https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git"  )
        stringParam('GIT_BRANCH' ,'seran_dev' )
    }
    definition{
        cpsScm{
            scm{
                git ("${params.GIT_URL}"){
                    branch ("${params.GIT_BRANCH}")
                }


            }
            scriptPath('pipeline/templates/jenkinsfile')
        }
    }
}