def call(String service_name, String env_file = null, int container_count = 1) {
    try {
        if (env_file?.trim()) {
            withEnv(["ENV_FILE=${env_file}"]) {
                sh "docker compose --env-file '${env_file}' up -d --scale ${service_name}=${container_count} ${service_name}"
            }
        } else {
            sh "docker compose up -d --scale ${service_name}=${container_count} ${service_name}"
        }
    } catch (err) {
        currentBuild.result = 'FAILURE'
        error("ERROR: failed at Deploy with -> ${err}")
    }
}
