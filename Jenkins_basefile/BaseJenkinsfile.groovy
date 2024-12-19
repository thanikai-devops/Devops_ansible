pipelineJobs("Base Pipeline env structure ") {
    description ("This Jobs runs the base pipeline structure from a Git repo")

    definition {
        cpsScm {
            Scm {
                git (
                    url: 'https://github.com/thanikai-devops/Devops_ansible.git'
                    branch: 'dev-jenkins'
                )
            }
            scriptpath('jenkinsfile/jenkinsfile')
        }
    }
} 