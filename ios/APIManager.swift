import Foundation

class APIManager {
    static let baseURLString = "https://api.justifi-staging.com"

  static func apiRequest(_ httpMethod: String, endpoint: String, body: [String: Any]? = nil, headers: [String: String]? = nil, completion: @escaping (Result<[String: Any], Error>) -> Void) {
      let urlString = "\(baseURLString)\(endpoint)"
      let url = URL(string: urlString)!
      var request = URLRequest(url: url)
      request.httpMethod = httpMethod
      request.addValue("application/json", forHTTPHeaderField: "Content-Type")

      if let headers = headers {
          for (key, value) in headers {
              request.setValue(value, forHTTPHeaderField: key)
          }
      }

      if let body = body {
          let jsonData = try! JSONSerialization.data(withJSONObject: body, options: [])
          request.httpBody = jsonData
      }

      let session = URLSession.shared
      let task = session.dataTask(with: request) { (data, response, error) in
            if let error = error {
                completion(.failure(error))
                print("API error: \(error.localizedDescription)")
                return
            }

            guard let data = data else {
                let error = NSError(domain: "APIManager", code: 0, userInfo: [NSLocalizedDescriptionKey: "Empty response"])
                completion(.failure(error))
                print("API error: Empty response")
                return
            }

        if let httpResponse = response as? HTTPURLResponse, httpResponse.statusCode != 200 && httpResponse.statusCode != 201 {
            if let jsonString = String(data: data, encoding: .utf8) {
                print("API error: HTTP response JSON \(jsonString)")
                let userInfo: [String: Any] = [NSLocalizedDescriptionKey: "HTTP response status code \(httpResponse.statusCode)", "JSON": jsonString]
                let error = NSError(domain: "APIManager", code: httpResponse.statusCode, userInfo: userInfo)
                completion(.failure(error))
            } else {
                let error = NSError(domain: "APIManager", code: httpResponse.statusCode, userInfo: nil)
                completion(.failure(error))
            }
            print("API error: HTTP response status code \(httpResponse.statusCode)")
            return
        }

            do {
                let json = try JSONSerialization.jsonObject(with: data, options: []) as! [String: Any]
                completion(.success(json))
            } catch {
                completion(.failure(error))
            }
        }

        task.resume()
    }

    static func createAuthToken(clientId: String, clientSecret: String, completion: @escaping (Result<[String: Any], Error>) -> Void) {
        let body = [
            "grant_type": "client_credentials",
            "client_id": clientId,
            "client_secret": clientSecret,
        ]
        apiRequest("POST", endpoint: "/oauth/token", body: body, completion: completion)
    }
  
  
  static func createPaymentMethod(body: [String: Any], completion: @escaping (Result<[String: Any], Error>) -> Void) {
      guard let clientId = UserDefaults.standard.string(forKey: "clientId") else {
          return
      }
      
      let encodedClientId = Data(clientId.utf8).base64EncodedString()
      let basicAuthHeader = "Basic \(encodedClientId):"
      let idempotencyKey = UUID().uuidString
      
      let headers = [
          "Authorization": basicAuthHeader,
          "Idempotency-Key": idempotencyKey,
          "Sub-Account": "acc_3VgkWT3JXKdNPnh2S5NRp3",
      ]
      
      print("Headers: \(headers)")
      
      apiRequest("POST", endpoint: "/v1/js/payment_methods", body: body, headers: headers, completion: completion)
  }


}

