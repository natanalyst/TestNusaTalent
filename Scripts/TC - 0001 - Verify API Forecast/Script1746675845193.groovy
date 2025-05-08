import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.util.KeywordUtil

request = findTestObject('Object Repository/forecast')
response = WS.sendRequest(request)
WS.verifyResponseStatusCode(response, 200)
String requestBody = response.getBodyContent().getText()
KeywordUtil.logInfo("JSON Request Body:\n" + requestBody)
WS.verifyElementPropertyValue(response, 'city.name', 'Jakarta')
String schemaJSON = '''
{
"$schema": "http://json-schema.org/draft-07/schema#",
"title": "Generated schema for Root",
"type": "object",
"properties": {
  "cod": {
	"type": "string"
  },
  "message": {
	"type": "number"
  },
  "cnt": {
	"type": "number"
  },
  "list": {
	"type": "array",
	"items": {
	  "type": "object",
	  "properties": {
		"dt": {
		  "type": "number"
		},
		"main": {
		  "type": "object",
		  "properties": {
			"temp": {
			  "type": "number"
			},
			"feels_like": {
			  "type": "number"
			},
			"temp_min": {
			  "type": "number"
			},
			"temp_max": {
			  "type": "number"
			},
			"pressure": {
			  "type": "number"
			},
			"sea_level": {
			  "type": "number"
			},
			"grnd_level": {
			  "type": "number"
			},
			"humidity": {
			  "type": "number"
			},
			"temp_kf": {
			  "type": "number"
			}
		  },
		  "required": [
			"temp",
			"feels_like",
			"temp_min",
			"temp_max",
			"pressure",
			"sea_level",
			"grnd_level",
			"humidity",
			"temp_kf"
		  ]
		},
		"weather": {
		  "type": "array",
		  "items": {
			"type": "object",
			"properties": {
			  "id": {
				"type": "number"
			  },
			  "main": {
				"type": "string"
			  },
			  "description": {
				"type": "string"
			  },
			  "icon": {
				"type": "string"
			  }
			},
			"required": [
			  "id",
			  "main",
			  "description",
			  "icon"
			]
		  }
		},
		"clouds": {
		  "type": "object",
		  "properties": {
			"all": {
			  "type": "number"
			}
		  },
		  "required": [
			"all"
		  ]
		},
		"wind": {
		  "type": "object",
		  "properties": {
			"speed": {
			  "type": "number"
			},
			"deg": {
			  "type": "number"
			},
			"gust": {
			  "type": "number"
			}
		  },
		  "required": [
			"speed",
			"deg",
			"gust"
		  ]
		},
		"visibility": {
		  "type": "number"
		},
		"pop": {
		  "type": "number"
		},
		"sys": {
		  "type": "object",
		  "properties": {
			"pod": {
			  "type": "string"
			}
		  },
		  "required": [
			"pod"
		  ]
		},
		"dt_txt": {
		  "type": "string"
		},
		"rain": {
		  "type": "object",
		  "properties": {
			"3h": {
			  "type": "number"
			}
		  },
		  "required": [
			"3h"
		  ]
		}
	  },
	  "required": [
		"dt",
		"main",
		"weather",
		"clouds",
		"wind",
		"visibility",
		"pop",
		"sys",
		"dt_txt"
	  ]
	}
  },
  "city": {
	"type": "object",
	"properties": {
	  "id": {
		"type": "number"
	  },
	  "name": {
		"type": "string"
	  },
	  "coord": {
		"type": "object",
		"properties": {
		  "lat": {
			"type": "number"
		  },
		  "lon": {
			"type": "number"
		  }
		},
		"required": [
		  "lat",
		  "lon"
		]
	  },
	  "country": {
		"type": "string"
	  },
	  "population": {
		"type": "number"
	  },
	  "timezone": {
		"type": "number"
	  },
	  "sunrise": {
		"type": "number"
	  },
	  "sunset": {
		"type": "number"
	  }
	},
	"required": [
	  "id",
	  "name",
	  "coord",
	  "country",
	  "population",
	  "timezone",
	  "sunrise",
	  "sunset"
	]
  }
},
"required": [
  "cod",
  "message",
  "cnt",
  "list",
  "city"
]
}
'''
WS.validateJsonAgainstSchema(response, schemaJSON)