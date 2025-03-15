package com.daniel.notify.repositoy;

import com.daniel.notify.model.NotifyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotifyRepository extends JpaRepository<NotifyEntity, String> {
}
