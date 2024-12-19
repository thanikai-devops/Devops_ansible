pipelineJobs("Base Pipeline env structure ") {
    description ("This Jobs runs the base pipeline structure from a Git repo")

    definition {
        cpsScm {
            Scm {
                git (
                    url: 
                    branch:
                )
            }
            scriptpath('jenkinsfile/jenkinsfile')
        }
    }
} 