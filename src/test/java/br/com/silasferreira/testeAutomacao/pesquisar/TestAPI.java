package br.com.silasferreira.testeAutomacao.pesquisar;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class TestAPI {
    @Test
    public void testApiOperacoes() {
        //Listando posts
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//
//
//        Response response = get("/posts");
//        Assertions.assertEquals(200, response.getStatusCode(), "Erro ao listar posts");
//        System.out.println("Response Body:");
//        System.out.println(response.asPrettyString());

        //Criando um post


                Response postResponse = given()
                .header("Content-Type", "application/json")
                .body("                {\n" +
                        "                    \"title\": \"Meu novo post\",\n" +
                        "                    \"body\": \"Este é o conteúdo do post.\",\n" +
                        "                    \"userId\": 1213\n" +
                        "                }")
                .post("/posts");
//
//        Assertions.assertEquals(201, postResponse.getStatusCode(), "Erro ao criar o código");
        int postId = postResponse.jsonPath().getInt("id"); //Extrai o id do novo post criado no retorno da API.

                Response updateResponse = given()
                .header("Content-Type", "application/json")
                .body("                {\n" +
                        "                    \"title\": \"Meu novo post\",\n" +
                        "                }")
                .put("/post" + postId);

        Assertions.assertEquals(200, updateResponse.getStatusCode(), "Erro ao atualozar o post");
    }
}