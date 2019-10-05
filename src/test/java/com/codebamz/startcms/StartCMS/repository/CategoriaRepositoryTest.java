package com.codebamz.startcms.StartCMS.repository;

import com.codebamz.startcms.StartCMS.component.TestDatabaseConfiguration;
import com.codebamz.startcms.StartCMS.model.Categoria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testInsert(){
        Categoria categoria = new Categoria();
        categoria.setNombre("Test1");
        categoria.setFecha(new Date());
        categoria.setDescripcion("Este es un mensaje de categoria superior");
        categoria.setCategoriaSuperior(1);

        boolean result = categoriaRepository.save(categoria);

        //categoriaRepository.deleteAll();

        //estamos esperando que este valor sea un resultado boleano verdadero
        Assert.assertTrue(result);
    }
}
