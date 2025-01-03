def call(String branch= "dev_dafin",String repourl='https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git'
,String credentialsId = 'BitbucketRepo') {
    // Fetch the Git configuration based on the project
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}
