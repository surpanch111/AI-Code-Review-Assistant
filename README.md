# AI-Powered Code Review Assistant

Companion project for the article "AI-Powered Code Review Assistant: Automated Code Analysis with Spring AI and MongoDB".

📌 Overview

Code reviews are an essential part of software development, but manually identifying recurring anti-patterns and potential maintainability issues can be time-consuming.

The AI-Powered Code Review Assistant explores an AI-assisted approach to code analysis by combining Spring Boot REST APIs, AI model integration, and MongoDB Atlas Vector Search.

The application maintains a collection of code review patterns, retrieves relevant patterns through semantic similarity search, and provides endpoints for submitting code reviews, retrieving historical results, and accessing review analytics.

This project demonstrates practical concepts in backend development, REST API design, AI integration, vector databases, and data persistence.

## Prerequisites

- Java 21 or later
- Maven 3.9+
- A MongoDB Atlas cluster with Atlas Vector Search enabled
- An OpenAI API key

## Setup

1. Clone the repository and navigate to the project directory.

2. Set environment variables:

```bash
export MONGODB_URI="mongodb+srv://<username>:<password>@<cluster>.mongodb.net/code-review-assistant?appName=devrel-article-java-springai-codereview"
export OPENAI_API_KEY="your-openai-api-key"
```

3. Create a Vector Search index on the `review_patterns` collection in Atlas:

   - Go to your cluster in the Atlas UI
   - Select the **Atlas Search** tab
   - Click **Create Search Index**
   - Choose **Atlas Vector Search**
   - Select the `review_patterns` collection
   - Name the index `vector_index`
   - Use this definition:

```json
{
  "fields": [
    {
      "type": "vector",
      "path": "embedding",
      "numDimensions": 1536,
      "similarity": "cosine"
    }
  ]
}
```

4. Build and run:

```bash
mvn spring-boot:run
```

The `DataSeeder` loads about 20 Java anti-patterns with embeddings on first startup.

## Repo Structure

AI-Code-Review-Assistant/
├── src/

│   └── main/
│       ├── java/                 # Application source code
│       └── resources/
│           └── application.properties
├── pom.xml                       # Maven dependencies and build configuration
├── README.md
└── .gitignore                    # Recommended: exclude build output and local secrets


## API endpoints

| Method | Endpoint                              | Description                        |
|--------|---------------------------------------|------------------------------------|
| POST   | `/api/patterns`                       | Add a new review pattern           |
| GET    | `/api/patterns`                       | List patterns (filter by language/category) |
| GET    | `/api/patterns/{id}`                  | Get a single pattern               |
| POST   | `/api/reviews`                        | Submit code for review             |
| GET    | `/api/reviews/{submissionId}`         | Get a past review with findings    |
| GET    | `/api/reviews/{submissionId}/findings`| Get findings for a submission      |
| GET    | `/api/analytics/categories`           | Finding counts by category         |
| GET    | `/api/analytics/severity`             | Finding counts by severity         |
| GET    | `/api/analytics/top-patterns`         | Most frequently triggered patterns |

## How It Works

<img width="822" height="1996" alt="mermaid-diagram" src="https://github.com/user-attachments/assets/9d51869b-c30c-43dd-b859-794eec94141e" />


    
## Example usage

Submit code for review:

```bash
curl -X POST http://localhost:8080/api/reviews \
  -H "Content-Type: application/json" \
  -d '{
    "code": "public void process() {\n    FileInputStream fis = new FileInputStream(\"data.txt\");\n    byte[] data = fis.readAllBytes();\n}",
    "language": "java"
  }'
```
## Author

Anil Sharma

GitHub: @surpanch111

Project: AI-Code-Review-Assistant

⭐ If you find this project useful, consider giving the repository a star and sharing feedback through GitHub Issues.
