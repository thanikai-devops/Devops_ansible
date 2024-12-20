pipelineJob("Automation_UAT") {
    description("This Job runs the base pipeline structure from a Git repo and it created and ref by seedJobs jenkins freestyle JObs")

    definition {
        cpsScm {
            scm {
                git('https://github.com/thanikai-devops/Devops_ansible.git'){
                    branch ('dev-jenkins')
                }
            }
            scriptPath('pipelines/jenkinsfile')  // Make sure this path is correct
        }
    }
}
