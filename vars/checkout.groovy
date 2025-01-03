def call() {
    // Fetch the Git configuration based on the project
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/seran-dev"]],
        userRemoteConfigs: [[
            url: 'https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git',
            credentialsId: credentials("BitbucketRepo")
        ]]
    ])
}
