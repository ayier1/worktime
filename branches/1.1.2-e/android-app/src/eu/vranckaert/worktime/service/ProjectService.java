/*
 *  Copyright 2011 Dirk Vranckaert
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.vranckaert.worktime.service;

import eu.vranckaert.worktime.exceptions.AtLeastOneProjectRequiredException;
import eu.vranckaert.worktime.exceptions.ProjectStillInUseException;
import eu.vranckaert.worktime.model.Project;

import java.util.List;

/**
 * User: DIRK VRANCKAERT
 * Date: 06/02/11
 * Time: 04:19
 */
public interface ProjectService {
    /**
     * Persist a new project instance.
     * @param project The {@link eu.vranckaert.worktime.model.Project} instance to persist.
     * @return The persisted instance.
     */
    Project save(Project project);

    /**
     * Find all persisted projects.
     * @return All projects.
     */
    List<Project> findAll();

    /**
     * Remove a project.
     * @param project The project to remove.
     * @throws AtLeastOneProjectRequiredException If this project is the last project available this exception is
     * thrown.
     * @throws ProjectStillInUseException If the project has one or more tasks this exception is thrown.
     */
    void remove(Project project) throws AtLeastOneProjectRequiredException, ProjectStillInUseException;

    /**
     * Checks if a certain name for a project is already in use.
     * @param projectName The name to check for duplicates.
     * @return {@link Boolean#TRUE} if a project with this name already exists, {@link Boolean#FALSE} if not.
     */
    boolean isNameAlreadyUsed(String projectName);

    /**
     * Checks if a certain name for a project is already in use, excluding the name of the excludedProject. Preferred
     * use in update-mode.
     * @param projectName The name to check for duplicates.
     * @param excludedProject The project which name should be ignored during the check.
     * @return {@link Boolean#TRUE} if a project with this name already exists, {@link Boolean#FALSE} if not.
     */
    boolean isNameAlreadyUsed(String projectName, Project excludedProject);

    /**
     * Check how many projects are available in the DB.
     * @return The number of projects found.
     */
    int countTotalNumberOfProjects();

    /**
     * Retrieve the selected project to be displayed in the widget and to which new
     * {@link eu.vranckaert.worktime.model.TimeRegistration} instances will be linked to.
     * @return The selected project. If no selected project is found the default project is used as the selected one.
     */
    Project getSelectedProject();

    /**
     * Updates an existing project.
     * @param project The project to update.
     * @return The updated project.
     */
    Project update(Project project);

    /**
     * Refreshes the project data. Should only be used when the project is expected not be loaded entirely (only the
     * id).
     * @param project The project to refresh.
     */
    void refresh(Project project);
}