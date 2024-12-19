def call(String environment = 'dev') {
    if (environment == 'dev') {
        echo "Deploy in dev stage"
    } else if (environment == 'UAT') {
        echo "Deploy in UAT stage"
    }
}