#---
# Excerpted from "Rails, Angular, Postgres, and Bootstrap",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/dcbang for more book information.
#---
350_000.times do |i|
  Customer.create!(
    first_name: Faker::Name.first_name,
     last_name: Faker::Name.last_name,
      username: "#{Faker::Internet.user_name}#{i}",
         email: "#{Faker::Internet.user_name}#{i}@#{Faker::Internet.domain_name}")
end
