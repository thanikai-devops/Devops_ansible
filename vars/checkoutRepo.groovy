def call(String branch= "seran_dev",String repourl='https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git') {
    // Fetch the Git configuration based on the project
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentials("BitbucketRepo")
        ]]
    ])
}
