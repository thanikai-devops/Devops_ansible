def call(String branch= "dev_dafin",String repourl='https://SciflareIT@bitbucket.org/web-sciflare/sciflare-website.git'
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
