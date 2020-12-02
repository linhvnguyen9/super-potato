#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}
#end

class ${Class_Name}UseCase (private val repository: ${Repository_name}Repository) {
    suspend operator fun invoke() = repository.${Repository_method_to_call}
}