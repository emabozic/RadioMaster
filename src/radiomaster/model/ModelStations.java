/*
 * /**
license The MIT License

Copyright (c) 2012-2016 Gauss, www.gauss.hr

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.model;

import java.util.List;


public class ModelStations {
    private int                     status;
    private String                  message;
    private Content                 content;

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the content
     */
    public Content getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Content content) {
        this.content = content;
    }

   


public static class Content {
    private int id;
    private String name;
    private boolean favorite;
    private String description; 
    private String country;
    private String website;
    private String twitter_url;
    private String facebook_url;
    private String slug;
    private String image_url;
    private String thumb_url;
    private String stream_url;
    private int stream_bitrate;
    private String categories;
    private int rating;
    private int favorite_count;
    private String created_at;
    private String updated_at;

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the favorite
         */
        public boolean isFavorite() {
            return favorite;
        }

        /**
         * @param favorite the favorite to set
         */
        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        /**
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description the description to set
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * @return the country
         */
        public String getCountry() {
            return country;
        }

        /**
         * @param country the country to set
         */
        public void setCountry(String country) {
            this.country = country;
        }

        /**
         * @return the website
         */
        public String getWebsite() {
            return website;
        }

        /**
         * @param website the website to set
         */
        public void setWebsite(String website) {
            this.website = website;
        }

        /**
         * @return the twitter_url
         */
        public String getTwitter_url() {
            return twitter_url;
        }

        /**
         * @param twitter_url the twitter_url to set
         */
        public void setTwitter_url(String twitter_url) {
            this.twitter_url = twitter_url;
        }

        /**
         * @return the facebook_url
         */
        public String getFacebook_url() {
            return facebook_url;
        }

        /**
         * @param facebook_url the facebook_url to set
         */
        public void setFacebook_url(String facebook_url) {
            this.facebook_url = facebook_url;
        }

        /**
         * @return the slug
         */
        public String getSlug() {
            return slug;
        }

        /**
         * @param slug the slug to set
         */
        public void setSlug(String slug) {
            this.slug = slug;
        }

        /**
         * @return the image_url
         */
        public String getImage_url() {
            return image_url;
        }

        /**
         * @param image_url the image_url to set
         */
        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        /**
         * @return the thumb_url
         */
        public String getThumb_url() {
            return thumb_url;
        }

        /**
         * @param thumb_url the thumb_url to set
         */
        public void setThumb_url(String thumb_url) {
            this.thumb_url = thumb_url;
        }

        /**
         * @return the stream_url
         */
        public String getStream_url() {
            return stream_url;
        }

        /**
         * @param stream_url the stream_url to set
         */
        public void setStream_url(String stream_url) {
            this.stream_url = stream_url;
        }

        /**
         * @return the stream_bitrate
         */
        public int getStream_bitrate() {
            return stream_bitrate;
        }

        /**
         * @param stream_bitrate the stream_bitrate to set
         */
        public void setStream_bitrate(int stream_bitrate) {
            this.stream_bitrate = stream_bitrate;
        }

        /**
         * @return the categories
         */
        public String getCategories() {
            return categories;
        }

        /**
         * @param categories the categories to set
         */
        public void setCategories(String categories) {
            this.categories = categories;
        }

        /**
         * @return the rating
         */
        public int getRating() {
            return rating;
        }

        /**
         * @param rating the rating to set
         */
        public void setRating(int rating) {
            this.rating = rating;
        }

        /**
         * @return the favorite_count
         */
        public int getFavorite_count() {
            return favorite_count;
        }

        /**
         * @param favorite_count the favorite_count to set
         */
        public void setFavorite_count(int favorite_count) {
            this.favorite_count = favorite_count;
        }

        /**
         * @return the created_at
         */
        public String getCreated_at() {
            return created_at;
        }

        /**
         * @param created_at the created_at to set
         */
        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        /**
         * @return the updated_at
         */
        public String getUpdated_at() {
            return updated_at;
        }

        /**
         * @param updated_at the updated_at to set
         */
        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

}



}