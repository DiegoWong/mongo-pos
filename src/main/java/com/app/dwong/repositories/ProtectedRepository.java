package com.app.dwong.repositories;

import org.springframework.security.access.prepost.PreAuthorize;


@PreAuthorize("#oauth2.hasScope('write')")
public interface ProtectedRepository {
}
