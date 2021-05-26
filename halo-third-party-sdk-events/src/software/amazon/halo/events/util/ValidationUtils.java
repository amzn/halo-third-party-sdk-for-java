
/*
    Copyright 2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
    except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
    the specific language governing permissions and limitations under the License.
 */

package software.amazon.halo.events.util;

/**
 * Useful utilities to validate dependencies.
 */
public final class ValidationUtils {

    /** Prevent instantiation. */
    private ValidationUtils() { }

    /**
     * Asserts that the given object is non-null and returns it.
     *
     * @param <T> type to evaluate
     * @param object
     *         Object to assert on
     * @param fieldName
     *         Field name to display in exception message if null
     * @return Object if non null
     * @throws IllegalArgumentException
     *         If object was null
     */
    public static <T> T assertNotNull(final T object, final String fieldName) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException(String.format("%s cannot be null", fieldName));
        }
        return object;
    }

    /**
     * Asserts that the given number is positive (non-negative and non-zero).
     *
     * @param num       Number to validate
     * @param fieldName Field name to display in exception message if not positive.
     * @return Number if positive.
     */
    public static int assertIsPositive(final int num, final String fieldName) {
        if (num <= 0) {
            throw new IllegalArgumentException(String.format("%s must be positive", fieldName));
        }
        return num;
    }
}
