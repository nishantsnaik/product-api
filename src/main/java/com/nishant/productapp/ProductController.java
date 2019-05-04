package com.nishant.productapp;

import java.net.URI;
import java.util.List;
/*
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
*/
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/products")
//@Api(tags = "products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service){
        this.service=service;
    }


    @GetMapping
    /*
    @ApiOperation(value="Find all products", notes = "Gets details on all the products")
    @ApiResponses(value = {@ApiResponse(code =200, message = "Success"),
            @ApiResponse(code =500, message = "Internal Server Error")})
            */
	public List<Product> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("{itemCode}")
    /*@ApiOperation(value="Find product by itemCode", notes = "Gets details of a product using item code")
    @ApiResponses(value = {@ApiResponse(code =200, message = "Success"),
            @ApiResponse(code =404, message = "Not Found"),
            @ApiResponse(code =500, message = "Internal Server Error")})
            */
	public EntityModel<Product> getProduct(@PathVariable("itemCode") String itemCode) {

        Product product = service.findOne(itemCode);
        EntityModel<Product> resource = new EntityModel(product);

        WebMvcLinkBuilder linkTo = linkTo(methodOn(ProductController.class).getAllProducts());
        resource.add(linkTo.withRel("all-products"));

        return resource;

		    }
	
	@PostMapping
    /*
    @ApiOperation(value="Add a new product", notes = "Add a new product")
    @ApiResponses(value = {@ApiResponse(code =201, message = "Created"),
            @ApiResponse(code =400, message = "Bad Request-Product Already exists"),
            @ApiResponse(code =500, message = "Internal Server Error")})
            */
    public ResponseEntity<Object> createProduct(@RequestBody Product product){

        Product createdProduct =  service.create(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{itemCode}")
                .buildAndExpand(createdProduct.getItemCode()).toUri();


        return ResponseEntity.created(location).build();

    }

    @PutMapping("{itemCode}")
    /*
    @ApiOperation(value="Update a product", notes = "Update a product")
    @ApiResponses(value = {@ApiResponse(code =200, message = "Success"),
            @ApiResponse(code =404, message = "Not Found"),
            @ApiResponse(code =500, message = "Internal Server Error")})
            */
    public Product updateProduct(@PathVariable("itemCode") String itemCode, @RequestBody Product product){
        return service.update(itemCode, product);
    }

    @DeleteMapping("{itemCode}")
    /*
    @ApiOperation(value="Delete a product", notes = "Delete a product")
    @ApiResponses(value = {@ApiResponse(code =200, message = "Success"),
            @ApiResponse(code =404, message = "Not Found"),
            @ApiResponse(code =500, message = "Internal Server Error")})
            */
    public void deleteProduct(@PathVariable("itemCode") String itemCode){
        service.delete(itemCode);
    }


}
