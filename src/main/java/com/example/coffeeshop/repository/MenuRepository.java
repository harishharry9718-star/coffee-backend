
package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.coffeeshop.entity.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {

}
