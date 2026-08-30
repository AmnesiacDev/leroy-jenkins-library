def call(String service_name){
  sh """
        docker compose build ${service_name}
        docker compose up -d --no-deps ${service_name}
    """
}
