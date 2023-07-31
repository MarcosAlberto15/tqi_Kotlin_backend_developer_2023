package jumarket.mercearia.auto.atendimento.exception

import java.lang.RuntimeException

data class BusinessException(override val message: String?): RuntimeException(message)

