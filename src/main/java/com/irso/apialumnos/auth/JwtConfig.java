package com.irso.apialumnos.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA ="alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA ="-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEowIBAAKCAQEAooBhFI+jrcIqD9jMy0fgUuRbA/XQqMZos5t7KZgsMfFHww49\r\n" + 
			"mMjzDuRF6kanyqidq0xXSLohjqxuiHOqApMrbDRKE4HkZnbeW00xuPdvBnAKOAse\r\n" + 
			"ZHAWF4DXOQ8OYpBLL96lwcpG2JMqlW4NF6F9gjzABqEhKTXMV2hGk/Ri3xlLPdHI\r\n" + 
			"82IjIrIWEca3S6BQBnAg5k13XDzI3SmnjVSl7GfCqIjMDO39UoN0Bd61DeKyGMs1\r\n" + 
			"bvfLpWIE/dxhK1yA0gnv1dWKuNGOxawZKy0GTT5vd1zcZ2U/F5tkqw+4c03hNMKp\r\n" + 
			"yi8a90oYsPVnZ1cihGP7BEV5dJd1BcB1vpwQRQIDAQABAoIBAEzV/xFFydMDF/he\r\n" + 
			"Ppdv6PXI2/BHbt4e0qr6PYYxWdRTjecA+MchXSwRa62Wswf0Knkwo6TTvcJEbg8/\r\n" + 
			"AYguJj4Hi28l3+VDF2h8W6Jl/K1ClNJjD3/WL9v1I87q+5ZHPAXqdN3o0w7cpyn4\r\n" + 
			"21/tD/dg2jtIPPHLak96EsUqrQVno1pU2LMJXCRpNlMdBsgIOqs+0S12e28MqF6S\r\n" + 
			"IsYI2q+w+FhbKzcuSreJh7/NQhu3A21iEbIBYmqF5He+YT69jU/YlNfRYUq+h76g\r\n" + 
			"sp2khaQW6IvjPjard2RrPmze/lnwV6WBOWhOyiLvXvzyracb89iWD7ZHTs7JugXa\r\n" + 
			"42wr3wECgYEA0u/mbN1pRw+bNMUXzl1AGKJliV8mIOBJcuvTG8V4NAJIex/iQaa+\r\n" + 
			"gUnCQ2bPArXArY1R+Te15DWILGLf5F/afDskPrPtl7CPmiStIKs0G08qaGK5WCmV\r\n" + 
			"4EidQOC2dulMCF0Lo741jykNTt3Mk9NTaspzGFSYWvRUjoCiVRcbM5ECgYEAxTeL\r\n" + 
			"1aBhfLEh9eq+OiWrG3BjUHqQ+bbNke0FginG09sF/+oJz73GhItyHnf18FQogG1s\r\n" + 
			"WvJ3GmSlaXYeFgxzizQTr1g/Ldn2hrYkItgkxk60ICv4ZFZQym/u8tmJo/CGFIov\r\n" + 
			"HkoIIb/zFP/r+BQEjWyZi4K1xJnmXh0NIcCoD3UCgYEAyciOcFP6Eu1d9sQYOuQ/\r\n" + 
			"nZE0eo4X5llISfRINgfYLkCE36ungFAna3yIpnuhyiDeGefXpAVkLdP72SIYtdnw\r\n" + 
			"IulcidMLlRFkvfsZ1ueP6BP6KHNQhIL7idtM+zQ7uFMC1flUWiZqC/Ikde59dmgx\r\n" + 
			"IzZZlcvPFysl/FAXejipX9ECgYBoU9sQVnhbyySI//ZDsluS92BCWaRJxW94C6fH\r\n" + 
			"VKxOtGW3HKq2D9FtmorzHUioKw0F61zPu8ZP2wA6CvcdeNbCw/jJ4GgDrHMijkYN\r\n" + 
			"fMPveAEHp9sN0S+J966zH2sVo456XSNR5Z3ppK5F5KCCqqxB2Dpdt/bKGxPno3yn\r\n" + 
			"50/AZQKBgF8JOh68dWAXL7htE1sKGfaXBolfXHK0rFBnPQmJXQ3dNfvjs9DCnX+e\r\n" + 
			"92o8JzPfqLL3H7w7tUmliFOTE3vjD08GZWIWVNMVeucd0O9TP6IirPfUpQG050Kz\r\n" + 
			"w/NCZ7G/GxTdP9f0seKMkZzUlK6qBeDqYMUhadV6KNRUq27QmpI3\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAooBhFI+jrcIqD9jMy0fg\r\n" + 
			"UuRbA/XQqMZos5t7KZgsMfFHww49mMjzDuRF6kanyqidq0xXSLohjqxuiHOqApMr\r\n" + 
			"bDRKE4HkZnbeW00xuPdvBnAKOAseZHAWF4DXOQ8OYpBLL96lwcpG2JMqlW4NF6F9\r\n" + 
			"gjzABqEhKTXMV2hGk/Ri3xlLPdHI82IjIrIWEca3S6BQBnAg5k13XDzI3SmnjVSl\r\n" + 
			"7GfCqIjMDO39UoN0Bd61DeKyGMs1bvfLpWIE/dxhK1yA0gnv1dWKuNGOxawZKy0G\r\n" + 
			"TT5vd1zcZ2U/F5tkqw+4c03hNMKpyi8a90oYsPVnZ1cihGP7BEV5dJd1BcB1vpwQ\r\n" + 
			"RQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
