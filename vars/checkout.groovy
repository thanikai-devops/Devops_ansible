def call(String gitbranch, String repourl, String credentialsId = "BitbucketRepo" ) {
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
IF USING PARAMETERS
// vars/checkoutRepo.groovy
// def call(Map params) {
//     def branch = params.get('branch', 'dev_dafin')  // Default branch if not provided
//     def repoUrl = params.get('repoUrl', 'https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git')  // Default repo URL
//     def credentialsId = params.get('credentialsId', 'BitbucketRepo')  // Default credentials ID

//     script {
//         checkout([
//             $class: 'GitSCM',
//             branches: [[name: "*/${branch}"]],
//             userRemoteConfigs: [[
//                 url: repoUrl,
//                 credentialsId: credentialsId
//             ]]
//         ])
//     }
// }
