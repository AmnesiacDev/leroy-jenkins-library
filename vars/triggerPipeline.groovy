def call(String job_name, String build_num, String has_update) {
    def result = build(
        job: job_name,
        wait: true,
        propagate: false,
        parameters: [
            string(
                name: 'IMAGE_TAG',
                value: build_num
            ),
            booleanParam(
                name: 'START_TEST',
                value: has_update.toBoolea()
            )
        ]
    )

    echo "Downstream pipeline ${job_name} result: ${result.result}"

    if (result.result != 'SUCCESS') {
        unstable("Downstream pipeline ${job_name} did not succeed: ${result.result}")
    }

    return result
}
