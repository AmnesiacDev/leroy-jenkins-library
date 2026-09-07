def call(String service_name, String env_file = null) {
    try {
        if (env_file?.trim()) {
            withEnv(["ENV_FILE=${env_file}"]) {
                sh "docker compose up -d '${service_name}'"
            }
        } else {
            sh "docker compose up -d '${service_name}'"
        }
    } catch (err) {
        currentBuild.result = 'FAILURE'
        error("ERROR: failed at Deploy with -> ${err}")
    }
}
